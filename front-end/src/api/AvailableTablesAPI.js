import axios from 'axios'

export default async function getTableNames() {
    const data = await axios.get("http://localhost:8080/api/available-tables");
    return data;
}