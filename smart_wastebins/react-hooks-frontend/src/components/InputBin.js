import React from 'react';
import Button from "../styling/ButtonStyling";
import flex from '../styling/FlexStylesheet.css';


const InputBin = ({onSubmit}) => {

    const handleSubmit=(e)=>{
        e.preventDefault();
        const nBins = e.target.numberOfBins.value;
        console.log("Number of bins: " + nBins);
        onSubmit(nBins);
      }

    return (

        <div className = "container" class="item_2">
           <form onSubmit={handleSubmit}>
                <input
                    onKeyPress={(event) => {
                        if (!/[1-9]/.test(event.key)) {
                        event.preventDefault();
                        }
                    }}
                    name = "numberOfBins"
                    placeholder="Number Of Bins"
                />
                <Button theme= "lightBlue"  >
                    Collect wastebins
                </Button>
            </form> 
        </div>
    )
}

export default InputBin