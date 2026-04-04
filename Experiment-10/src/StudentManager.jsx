import { useState } from 'react'
import './StudentManager.css'

const initialStudents = [
  { id: 101, name: 'Aarav Sharma', course: 'Mathematics' },
  { id: 102, name: 'Mia Johnson', course: 'Computer Science' },
  { id: 103, name: 'Liam Chen', course: 'Physics' },
  { id: 104, name: 'Sofia Martinez', course: 'Chemistry' },
  { id: 105, name: 'Noah Wilson', course: 'Biology' },
]

const emptyStudent = {
  id: '',
  name: '',
  course: '',
}

function StudentManager() {
  const [students, setStudents] = useState(initialStudents)
  const [newStudent, setNewStudent] = useState(emptyStudent)

  const handleInputChange = (event) => {
    const { name, value } = event.target
    setNewStudent((prev) => ({
      ...prev,
      [name]: name === 'id' ? value.replace(/\D/g, '') : value,
    }))
  }

  const handleAddStudent = () => {
    const trimmedName = newStudent.name.trim()
    const trimmedCourse = newStudent.course.trim()

    if (!newStudent.id || !trimmedName || !trimmedCourse) {
      return
    }

    const studentToAdd = {
      id: Number(newStudent.id),
      name: trimmedName,
      course: trimmedCourse,
    }

    setStudents((prev) => [...prev, studentToAdd])
    setNewStudent(emptyStudent)
  }

  const handleDeleteStudent = (id) => {
    setStudents((prev) => prev.filter((student) => student.id !== id))
  }

  return (
    <div className="student-manager-container">
      <h1>Student Manager</h1>

      <div className="student-form">
        <input
          type="number"
          name="id"
          placeholder="Enter ID"
          value={newStudent.id}
          onChange={handleInputChange}
        />
        <input
          type="text"
          name="name"
          placeholder="Enter Name"
          value={newStudent.name}
          onChange={handleInputChange}
        />
        <input
          type="text"
          name="course"
          placeholder="Enter Course"
          value={newStudent.course}
          onChange={handleInputChange}
        />
        <button className="btn-add" onClick={handleAddStudent}>
          Add Student
        </button>
      </div>

      {students.length === 0 ? (
        <p className="empty-message">No students available</p>
      ) : (
        <table className="students-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button
                    className="btn-delete"
                    onClick={() => handleDeleteStudent(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  )
}

export default StudentManager
