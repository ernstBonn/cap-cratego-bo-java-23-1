import React from 'react';
import {StorageModel} from "../models/StorageModel";
type Props = {
    storage: StorageModel
}
function StorageCard(props: Props) {

    const { storage } = props;

    const imageDataUrl = `data:image/jpeg;base64,${storage.image}`;

    return (
                <article>
                    <img src={imageDataUrl} alt="Storage Image" />
                    <h3>{props.storage.description}</h3>
                    <p><em>{props.storage.crts_now}</em> / <em>{props.storage.crts_org}</em></p>
                    <a href="#">Details</a>
                </article>
    );
}

export default StorageCard;