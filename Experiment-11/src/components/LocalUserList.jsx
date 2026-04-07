import { useEffect, useState } from 'react'

function LocalUserList() {
  const [users, setUsers] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    const fetchLocalUsers = async () => {
      setLoading(true)
      setError('')

      try {
        const response = await fetch('/users.json')

        if (!response.ok) {
          throw new Error('Could not load local users data.')
        }

        const data = await response.json()
        setUsers(data)
      } catch {
        setError('Failed to fetch local users. Please try again.')
      } finally {
        setLoading(false)
      }
    }

    fetchLocalUsers()
  }, [])

  if (loading) {
    return <p className="status-message">Loading local users...</p>
  }

  if (error) {
    return <p className="status-message error">{error}</p>
  }

  return (
    <div className="list-grid">
      {users.map((user) => (
        <article className="info-card" key={user.id}>
          <h3>{user.name}</h3>
          <p>
            <span>Email:</span> {user.email}
          </p>
          <p>
            <span>Phone:</span> {user.phone}
          </p>
        </article>
      ))}
    </div>
  )
}

export default LocalUserList
