import React from 'react';
import { useState } from 'react';
import InputBin from './InputBin';
import ListBinComponent from './ListBinComponent';

const CollectBins = () => {
    const [nBins, setNBins] = useState(-1);
    //nBins < 0 for all wastebins

    return (
      <div>
        <ListBinComponent nBins={nBins} />
        <InputBin onSubmit={n => setNBins(n)} />
      </div>
    );
}

export default CollectBins