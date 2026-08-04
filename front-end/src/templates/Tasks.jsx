import "../styles/tasks.scss"
import Header from "./Header"

import Exclamation from "../assets/danger.png"
import Plus from "../assets/plus.png"
export default function Tasks() {

    return (
        <div className="container">
            <Header />
            <div className="content">
                <div className="task-cards">
                    <div className="card">
                        <div className="additional" id="details">
                            <span>Details</span>
                            <a href="#">
                                <img src={Exclamation} alt="more info" />
                            </a>
                        </div>

                        <div>
                            <span className="status">TODO</span>
                            <hr/>
                        </div>
                        <span>Title:</span>
                        <span>Description:</span>
                        <span>DeadLine:</span>
                        <div className="additional" id="user">
                            <a href="#">
                                <img src={Plus} alt="add user" />
                            </a>
                        </div>
                    </div>
                    <div className="card">
                        <div className="additional" id="details">
                            <span>Details</span>
                            <a href="#">
                                <img src={Exclamation} alt="more info" />
                            </a>
                        </div>

                        <div>
                            <span className="status">TODO</span>
                            <hr/>
                        </div>
                        <span>Title:</span>
                        <span>Description:</span>
                        <span>DeadLine:</span>
                        <div className="additional" id="user">
                            <a href="#">
                                <img src={Plus} alt="add user" />
                            </a>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    )
}