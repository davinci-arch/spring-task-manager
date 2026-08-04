import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import '../styles/index.css'
import MainPage from './MainPage'
import Tasks from './Tasks'
import ProjectPage from './ProjectPage'
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Tasks/>
  </StrictMode>,
)
