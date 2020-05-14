import React, { Component } from 'react'
import { Alert } from 'reactstrap'

export default class NotFound extends Component {
    render() {
        return (
            <div>
                <Alert color="danger">
                    <h5>Page is not found !</h5>
                </Alert>
                
            </div>
        )
    }
}