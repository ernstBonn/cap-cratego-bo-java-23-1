import React from 'react';
import {StorageModel} from "../models/StorageModel";
import StorageCard from "../cards/StorageCard";

type Props = {
    storages: StorageModel[]
}

function StorageGallery(props: Props) {
    return (
        <div>
            {props.storages.map(current => <StorageCard storage={current}/>)}
        </div>
    );
}

export default StorageGallery;