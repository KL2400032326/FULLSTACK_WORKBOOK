import { Link, Route, Routes } from 'react-router-dom'
import Dashboard from './components/Dashboard'
import AddStudent from './components/AddStudent'
import ViewStudents from './components/ViewStudents'
import UpdateStudent from './components/UpdateStudent'
import SearchStudent from './components/SearchStudent'
import CourseFilter from './components/CourseFilter'
import './App.css'

function App() {
  return (
    <div className="app-container">
      <nav className="top-nav">
        <Link to="/">Dashboard</Link>
        <Link to="/add">Add</Link>
        <Link to="/view">View</Link>
        <Link to="/search">Search</Link>
        <Link to="/course">Course Filter</Link>
      </nav>

      <main className="content-wrap">
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/add" element={<AddStudent />} />
          <Route path="/view" element={<ViewStudents />} />
          <Route path="/update/:id" element={<UpdateStudent />} />
          <Route path="/search" element={<SearchStudent />} />
          <Route path="/course" element={<CourseFilter />} />
        </Routes>
      </main>
    </div>
  )
}

export default App
