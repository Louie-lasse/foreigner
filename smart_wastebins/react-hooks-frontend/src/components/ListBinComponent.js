import React,{useState,useEffect} from 'react'
import BinService from '../services/BinService'

const ListBinComponent = ({nBins}) => {

    const [bins, setBins] = useState([])

    useEffect(() => {
        BinService.getBins(nBins).then((response) => {
            setBins(response.data)
            console.log(response.data);
        }).catch( error => {
            console.log(error);
        })
    
    }, [nBins])

    return (
        <div className = "container">
            <h2 className = "text-center"> List of Big-Belly Bins</h2>
            <table className ="table table-bordered table-striped">
                <thead>
                    <th>Longitude</th>
                    <th>Latitude</th>
                    <th>Fullness</th>
                </thead>
                <tbody>
                    {
                        bins.map(
                            bin =>
                                <tr>
                                    <td> {bin.coordinates.x} </td>
                                    <td> {bin.coordinates.y} </td>
                                     <td> {bin.fullness} </td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListBinComponent