import { useState } from 'react'
import FakePostList from './FakePostList'
import LocalUserList from './LocalUserList'
import UserList from './UserList'

const sections = {
  local: {
    label: 'Local Users',
    heading: 'Local JSON Users',
    description: 'Data loaded from users.json using the Fetch API.',
    component: <LocalUserList />,
  },
  usersApi: {
    label: 'Users API',
    heading: 'Public Users API',
    description: 'Data loaded from JSONPlaceholder using the Fetch API.',
    component: <UserList />,
  },
  fakeApi: {
    label: 'Fake API Posts',
    heading: 'Fake API Posts (Axios)',
    description: 'Data loaded from DummyJSON using Axios with filter and refresh.',
    component: <FakePostList />,
  },
}

function Dashboard() {
  const [activeSection, setActiveSection] = useState('local')

  return (
    <main className="dashboard-container">
      <section className="dashboard-card">
        <header className="dashboard-header">
          <p className="eyebrow">News Portal Dashboard</p>
          <h1>API Integration Demo</h1>
          <p>Choose a section to view local and remote data sources.</p>
        </header>

        <nav className="dashboard-nav" aria-label="Dashboard sections">
          {Object.entries(sections).map(([key, section]) => (
            <button
              key={key}
              type="button"
              className={activeSection === key ? 'tab-button active' : 'tab-button'}
              onClick={() => setActiveSection(key)}
            >
              {section.label}
            </button>
          ))}
        </nav>

        <section className="dashboard-content">
          <h2>{sections[activeSection].heading}</h2>
          <p className="section-description">{sections[activeSection].description}</p>
          {sections[activeSection].component}
        </section>
      </section>
    </main>
  )
}

export default Dashboard
