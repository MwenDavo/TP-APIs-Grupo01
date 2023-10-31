import React from 'react';

function List({ listValues }) {
    return (
        <div>
            {
                listValues.length ?
                    listValues.map((value) => {
                        return (
                            <div>
                                <img src={value.images['original'].url} />
                            </div>
                        )
                    })
                    :
                    <></>
            }
        </div>
    );
}

export default List;