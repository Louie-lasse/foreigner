import React from 'react';
import BinService from "../services/BinService";
import PathService from "../services/PathService";
import InputBin from "./InputBin";
import '../styling/FlexStylesheet.css';

const InputPath = ({onSubmit}) => {

    const lat = 57.688343;
    const lng = 11.979447;


    const sendBins = (n) => {
        PathService.getPath(lat,lng).then(
            response => {
                onSubmit(response.data.right)
            }
        ).catch(
            error => console.log(error)
        )
    }

    return (
        <div style={{
            display: 'flex',
            align: 'right',
        }}>
            <InputBin onSubmit={n => sendBins(n)}/>
        </div>
    )
}

export default InputPath