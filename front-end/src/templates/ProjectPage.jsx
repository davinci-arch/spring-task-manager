import Header from "./Header"
import "../styles/projectPage.scss"
import PlustPng from '../assets/plus.png'
export default function ProjectPage() {

    return (
        <div className="container">
            <Header />
            <div className="content">
                <div className="project-cards">
                    <div className="card">
                        <h3>Title</h3>
                        <span>Project leader</span>
                        <a href="#" target="_blank">To project</a>
                    </div>
                    <div className="card">
                        <h3>Title</h3>
                        <span>Project leader</span>
                        <a href="#" target="_blank">To project</a>
                    </div>
                    <div className="blank-card card">
                        <div>
                            <h2>Create new project</h2>
                            <img src={PlustPng} alt="Add new item" />
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    )
}