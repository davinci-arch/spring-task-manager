import { useState } from 'react';
import '../styles/mainPage.scss'
export default function MainPage() {
    const [entityName, setEntityName] = useState("")
    const [entities, setEntities] = useState([
        "Task",
        "Project",
        "User"
    ])


    return (
        <div className="container">
            <header className="head-bar">
                <div id="app-name">Task manager</div>
                <div className="menu-container">
                    <ul className="menu">
                        <li className="menu-item">Entities</li>
                        <li className="menu-item">Project</li>
                    </ul>
                </div>
            </header>
            <div className="content">
                <div className="data-container">
                    <div className="entity-input">
                        <input type="text" 
                        name="entityName"  
                        id="" 
                        list="entities"
                        placeholder="Choose which entity need to load"
                        value={entityName}
                        onChange={e => setEntityName(e.target.value)}
                          />
                        <datalist id="entities">
                            {entities.map(value => (
                                <option value={value} key={value} />
                            ))}
                        </datalist>
                    </div>
                    <div className="entity-table-container">
                        <h1>{entityName === "" ? "Entity name" : entityName}</h1>
                        <table>
                            <tr>
                                <th>Months</th>
                                <th>Savings</th>
                            </tr>
                            <tr>
                                <td>January</td>
                                <td>$1000</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
}