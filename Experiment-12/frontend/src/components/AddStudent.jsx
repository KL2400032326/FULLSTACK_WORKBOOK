import { useState } from 'react'
import API from '../api/axiosConfig'

function AddStudent() {
  const [name, setName] = useState('')
  const [course, setCourse] = useState('')
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')
  const [success, setSuccess] = useState('')

  const handleSubmit = async (event) => {
    event.preventDefault()

    if (!name.trim() || !course.trim()) {
      setError('Please fill in both Name and Course.')
      setSuccess('')
      return
    }

    try {
      setLoading(true)
      setError('')
      setSuccess('')

      await API.post('/student/add', {
        name: name.trim(),
        course: course.trim(),
      })

      setSuccess('Student added successfully.')
      setName('')
      setCourse('')
    } catch (err) {
      setError(err.response?.data?.message || 'Failed to add student.')
    } finally {
      setLoading(false)
    }
  }

  return (
    <section className="card">
      <h2>Add Student</h2>
      <form className="form" onSubmit={handleSubmit}>
        <label htmlFor="name">Name</label>
        <input
          id="name"
          type="text"
          value={name}
          onChange={(event) => setName(event.target.value)}
          placeholder="Enter student name"
        />

        <label htmlFor="course">Course</label>
        <input
          id="course"
          type="text"
          value={course}
          onChange={(event) => setCourse(event.target.value)}
          placeholder="Enter course"
        />

        <button className="btn" type="submit" disabled={loading}>
          {loading ? 'Adding...' : 'Add Student'}
        </button>
      </form>

      {success && <p className="message success">{success}</p>}
      {error && <p className="message error">{error}</p>}
    </section>
  )
}

export default AddStudent
