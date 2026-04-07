import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import API from '../api/axiosConfig'

function ViewStudents() {
  const navigate = useNavigate()
  const [students, setStudents] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')

  const fetchStudents = async () => {
    try {
      setLoading(true)
      setError('')
      const response = await API.get('/student/getall')
      setStudents(Array.isArray(response.data) ? response.data : [])
    } catch (err) {
      setError(err.response?.data?.message || 'Failed to load students.')
      setStudents([])
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchStudents()
  }, [])

  const handleDelete = async (id) => {
    const confirmed = window.confirm('Are you sure you want to delete this student?')
    if (!confirmed) return

    try {
      setError('')
      await API.delete(`/student/delete/${id}`)
      fetchStudents()
    } catch (err) {
      setError(err.response?.data?.message || 'Failed to delete student.')
    }
  }

  return (
    <section className="card">
      <h2>All Students</h2>

      {loading && <p className="message">Loading students...</p>}
      {error && <p className="message error">{error}</p>}

      {!loading && !error && students.length === 0 && (
        <p className="message">No students found.</p>
      )}

      {!loading && students.length > 0 && (
        <div className="table-wrap">
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Course</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {students.map((student) => (
                <tr key={student.id}>
                  <td>{student.id}</td>
                  <td>{student.name}</td>
                  <td>{student.course}</td>
                  <td className="actions-cell">
                    <button
                      className="btn small"
                      onClick={() =>
                        navigate(`/update/${student.id}`, { state: { student } })
                      }
                    >
                      Update
                    </button>
                    <button
                      className="btn danger small"
                      onClick={() => handleDelete(student.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </section>
  )
}

export default ViewStudents
