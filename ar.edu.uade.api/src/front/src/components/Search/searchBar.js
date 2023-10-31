import React from 'react';
import styles from './searchBar.module.css';

function SearchBar({ handleChange }) {
    return (
        <input className={styles.input} onChange={onhandleChange} />
    )
}

export default SearchBar;