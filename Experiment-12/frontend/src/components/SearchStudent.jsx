import { useState } from 'react'
import API from '../api/axiosConfig'

function SearchStudent() {
  const [name, setName] = useState('')
  const [course, setCourse] = useState('')
  const [students, setStudents] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')

  const handleSearch = async (event) => {
    event.preventDefault()

    if (!name.trim() && !course.trim()) {
      setError('Enter at least Name or Course to search.')
      setStudents([])
      return
    }

    const params = new URLSearchParams()
    if (name.trim()) params.append('name', name.trim())
    if (course.trim()) params.append('course', course.trim())

    try {
      setLoading(true)
      setError('')
      const response = await API.get(`/student/search?${params.toString()}`)
      setStudents(Array.isArray(response.data) ? response.data : [])
    } catch (err) {
      setError(err.response?.data?.message || 'Search failed.')
      setStudents([])
    } finally {
      setLoading(false)
    }
  }

  return (
    <section className="card">
      <h2>Search Students</h2>

      <form className="form" onSubmit={handleSearch}>
        <label htmlFor="search-name">Name</label>
        <input
          id="search-name"
          type="text"
          value={name}
          onChange={(event) => setName(event.target.value)}
          placeholder="Enter name"
        />

        <label htmlFor="search-course">Course</label>
        <input
          id="search-course"
          type="text"
          value={course}
          onChange={(event) => setCourse(event.target.value)}
          placeholder="Enter course"
        />

        <button className="btn" type="submit" disabled={loading}>
          {loading ? 'Searching...' : 'Search'}
        </button>
      </form>

      {error && <p className="message error">{error}</p>}
      {!loading && !error && students.length === 0 && (
        <p className="message">Search results will appear here.</p>
      )}

      {!loading && students.length > 0 && (
        <div className="table-wrap">
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Course</th>
              </tr>
            </thead>
            <tbody>
              {students.map((student) => (
                <tr key={student.id}>
                  <td>{student.id}</td>
                  <td>{student.name}</td>
                  <td>{student.course}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </section>
  )
}

export default SearchStudent
