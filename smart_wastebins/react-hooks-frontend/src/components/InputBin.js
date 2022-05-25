import React from 'react';
import Button from "../styling/ButtonStyling";


const InputBin = ({onSubmit}) => {

    const handleSubmit=(e)=>{
        e.preventDefault();
        const nBins = e.target.numberOfBins.value;
        onSubmit(nBins);
      }

    return (

        <div className = "container" class="item_2">
           <form onSubmit={handleSubmit}>
               <input
                    onKeyPress={(event) => {
                        if (!/[0-9]/.test(event.key)) {
                        event.preventDefault();
                        }
                    }}
                    name = "numberOfBins"
                />
                <Button theme= "lightBlue"  >
                    Display Bins
                </Button>
            </form>
        </div>
    )
}

export default InputBin