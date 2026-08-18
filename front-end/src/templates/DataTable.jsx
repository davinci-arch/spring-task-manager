export default function DataTable({ data }) {
    return (
        data.length > 0 && (
            <table>
                <thead>
                    <tr>
                        {Object.keys(data[0]).map(key => (
                            <th key={key}>{key}</th>
                        ))}
                    </tr>
                </thead>

                <tbody>
                    {data.map((object, index) => (
                        <tr key={index}>
                            {Object.values(object).map((value, index) => (
                                <td key={index}>{value}</td>
                            ))}
                        </tr>
                    ))}
                </tbody>
            </table>
        )
    );
}