import { useEffect, useState } from 'react'

function UserList() {
  const [users, setUsers] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    const fetchUsers = async () => {
      setLoading(true)
      setError('')

      try {
        const response = await fetch('https://jsonplaceholder.typicode.com/users')

        if (!response.ok) {
          throw new Error('Could not load API users data.')
        }

        const data = await response.json()
        setUsers(data)
      } catch {
        setError('Failed to fetch users from API. Please try again.')
      } finally {
        setLoading(false)
      }
    }

    fetchUsers()
  }, [])

  if (loading) {
    return <p className="status-message">Loading users from API...</p>
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

export default UserList
