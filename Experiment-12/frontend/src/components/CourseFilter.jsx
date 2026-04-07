import { useState } from 'react'
import API from '../api/axiosConfig'

function CourseFilter() {
  const [course, setCourse] = useState('')
  const [students, setStudents] = useState([])
  const [page, setPage] = useState(0)
  const [size] = useState(5)
  const [totalPages, setTotalPages] = useState(0)
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')

  const fetchByCourse = async (requestedPage) => {
    if (!course.trim()) {
      setError('Please select or enter a course.')
      setStudents([])
      return
    }

    try {
      setLoading(true)
      setError('')

      const response = await API.get(
        `/student/course/${encodeURIComponent(course.trim())}?page=${requestedPage}&size=${size}`,
      )

      if (Array.isArray(response.data)) {
        setStudents(response.data)
        setTotalPages(response.data.length < size ? requestedPage + 1 : requestedPage + 2)
      } else {
        setStudents(response.data.content || [])
        setTotalPages(response.data.totalPages || 0)
      }

      setPage(requestedPage)
    } catch (err) {
      setError(err.response?.data?.message || 'Failed to filter students by course.')
      setStudents([])
    } finally {
      setLoading(false)
    }
  }

  const handleSubmit = (event) => {
    event.preventDefault()
    fetchByCourse(0)
  }

  const handlePrevious = () => {
    if (page > 0) {
      fetchByCourse(page - 1)
    }
  }

  const handleNext = () => {
    if (totalPages === 0 || page + 1 < totalPages) {
      fetchByCourse(page + 1)
    }
  }

  return (
    <section className="card">
      <h2>Filter Students by Course</h2>

      <form className="form" onSubmit={handleSubmit}>
        <label htmlFor="course-filter">Course</label>
        <select
          id="course-filter"
          value={course}
          onChange={(event) => setCourse(event.target.value)}
        >
          <option value="">Select course</option>
          <option value="Java">Java</option>
          <option value="Python">Python</option>
          <option value="React">React</option>
          <option value="Spring Boot">Spring Boot</option>
          <option value="Data Science">Data Science</option>
        </select>

        <button className="btn" type="submit" disabled={loading}>
          {loading ? 'Loading...' : 'Apply Filter'}
        </button>
      </form>

      {error && <p className="message error">{error}</p>}

      {!loading && students.length > 0 && (
        <>
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

          <div className="pagination">
            <button className="btn small" onClick={handlePrevious} disabled={loading || page === 0}>
              Previous
            </button>
            <span>Page {page + 1}</span>
            <button
              className="btn small"
              onClick={handleNext}
              disabled={loading || (totalPages > 0 && page + 1 >= totalPages)}
            >
              Next
            </button>
          </div>
        </>
      )}

      {!loading && !error && students.length === 0 && (
        <p className="message">No filtered records yet. Select a course and apply filter.</p>
      )}
    </section>
  )
}

export default CourseFilter
