import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import '../styles/index.css'
import MainPage from './MainPage'
import ProjectPage from './ProjectPage'
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ProjectPage/>
  </StrictMode>,
)
