import axios from 'axios'
import { useEffect, useMemo, useState } from 'react'

function FakePostList() {
  const [posts, setPosts] = useState([])
  const [selectedUserId, setSelectedUserId] = useState('all')
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  const fetchPosts = async () => {
    setLoading(true)
    setError('')

    try {
      const response = await axios.get('https://dummyjson.com/posts')
      setPosts(response.data.posts)
    } catch {
      setError('Failed to fetch posts from fake API. Please try again.')
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchPosts()
  }, [])

  const userIds = useMemo(() => {
    const ids = [...new Set(posts.map((post) => post.userId))]
    return ids.sort((a, b) => a - b)
  }, [posts])

  const filteredPosts =
    selectedUserId === 'all'
      ? posts
      : posts.filter((post) => post.userId === Number(selectedUserId))

  return (
    <section>
      <div className="toolbar">
        <label htmlFor="userFilter">Filter by User ID:</label>
        <select
          id="userFilter"
          value={selectedUserId}
          onChange={(event) => setSelectedUserId(event.target.value)}
        >
          <option value="all">All Users</option>
          {userIds.map((id) => (
            <option key={id} value={id}>
              User {id}
            </option>
          ))}
        </select>

        <button type="button" onClick={fetchPosts}>
          Refresh
        </button>
      </div>

      {loading && <p className="status-message">Loading fake API posts...</p>}
      {!loading && error && <p className="status-message error">{error}</p>}

      {!loading && !error && (
        <div className="list-grid posts-grid">
          {filteredPosts.map((post) => (
            <article className="info-card" key={post.id}>
              <h3>{post.title}</h3>
              <p>{post.body}</p>
            </article>
          ))}
        </div>
      )}
    </section>
  )
}

export default FakePostList
