import { Link } from 'react-router-dom'

function Dashboard() {
  return (
    <section className="card">
      <h1>Student Management System</h1>
      <p className="subtitle">Choose an action to manage student records.</p>

      <div className="grid-actions">
        <Link className="btn" to="/add">
          Add Student
        </Link>
        <Link className="btn" to="/view">
          View All Students
        </Link>
        <Link className="btn" to="/search">
          Search Students
        </Link>
        <Link className="btn" to="/course">
          Filter by Course
        </Link>
      </div>
    </section>
  )
}

export default Dashboard
