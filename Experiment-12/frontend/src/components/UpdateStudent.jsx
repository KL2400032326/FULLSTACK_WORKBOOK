import { useEffect, useState } from 'react'
import { useLocation, useNavigate, useParams } from 'react-router-dom'
import API from '../api/axiosConfig'

function UpdateStudent() {
  const { id } = useParams()
  const location = useLocation()
  const navigate = useNavigate()

  const [name, setName] = useState('')
  const [course, setCourse] = useState('')
  const [loading, setLoading] = useState(false)
  const [initialLoading, setInitialLoading] = useState(false)
  const [error, setError] = useState('')
  const [success, setSuccess] = useState('')

  useEffect(() => {
    const selectedStudent = location.state?.student

    if (selectedStudent) {
      setName(selectedStudent.name || '')
      setCourse(selectedStudent.course || '')
      return
    }

    const fetchStudentFromList = async () => {
      try {
        setInitialLoading(true)
        setError('')
        const response = await API.get('/student/getall')
        const list = Array.isArray(response.data) ? response.data : []
        const found = list.find((item) => String(item.id) === String(id))

        if (!found) {
          setError('Student not found.')
          return
        }

        setName(found.name || '')
        setCourse(found.course || '')
      } catch (err) {
        setError(err.response?.data?.message || 'Failed to load student details.')
      } finally {
        setInitialLoading(false)
      }
    }

    fetchStudentFromList()
  }, [id, location.state])

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

      await API.put(`/student/update/${id}`, {
        name: name.trim(),
        course: course.trim(),
      })

      setSuccess('Student updated successfully.')
      setTimeout(() => {
        navigate('/view')
      }, 900)
    } catch (err) {
      setError(err.response?.data?.message || 'Failed to update student.')
    } finally {
      setLoading(false)
    }
  }

  return (
    <section className="card">
      <h2>Update Student</h2>

      {initialLoading ? (
        <p className="message">Loading student details...</p>
      ) : (
        <form className="form" onSubmit={handleSubmit}>
          <label htmlFor="name">Name</label>
          <input
            id="name"
            type="text"
            value={name}
            onChange={(event) => setName(event.target.value)}
            placeholder="Enter updated name"
          />

          <label htmlFor="course">Course</label>
          <input
            id="course"
            type="text"
            value={course}
            onChange={(event) => setCourse(event.target.value)}
            placeholder="Enter updated course"
          />

          <button className="btn" type="submit" disabled={loading}>
            {loading ? 'Updating...' : 'Update Student'}
          </button>
        </form>
      )}

      {success && <p className="message success">{success}</p>}
      {error && <p className="message error">{error}</p>}
    </section>
  )
}

export default UpdateStudent
