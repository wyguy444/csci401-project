import * as React from 'react';
import {
    Panel,
    Button,
    Form,
    FormGroup,
    Col,
    FormControl,
    ControlLabel,
    DropdownButton,
    MenuItem
} from 'react-bootstrap';
import SubmitDeliverables from './SubmittedDeliverables';

interface DeliverableProps {

}

interface DeliverableState {
    deliverableNumber: number;
    deliverableFile: File;
    name: string;
    description: string;
    dueDate: string;
    status: string;
    dateSubmitted: string;
    projectNumber: number;
}

class SubmitDeliverable extends React.Component<DeliverableProps, DeliverableState> {
    constructor(props: DeliverableProps) {
        super(props);
        this.state = {
            deliverableNumber: 1,
            deliverableFile: new File([], ''),
            name: '',
            description: '',
            dueDate: '',
            status: '',
            dateSubmitted: '',
            projectNumber: 0
        };
        this.submitClicked = this.submitClicked.bind(this);
        this.uploadFile = this.uploadFile.bind(this);
        this.uploadFileClicked = this.uploadFileClicked.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleDropdownClick = this.handleDropdownClick.bind(this);
        this.handleFileChange = this.handleFileChange.bind(this);
    }

    handleFileChange(e: any) {
        this.setState({ deliverableFile: e.target.files[0] });
    }

    handleChange(e: any) {
        this.setState({ [e.target.id]: e.target.value });
    }

    handleDropdownClick(value: number) {
        this.setState({ deliverableNumber: value});
    }

    uploadFileClicked(e: any) {
        e.preventDefault();
        this.uploadFile(this.state.deliverableFile);
        this.submitClicked();
    }

    uploadFile(file: File) {
        var request = new XMLHttpRequest();
        request.withCredentials = true;
        request.open('POST', 'http://localhost:8080/deliverable/upload');
        // request.setRequestHeader('Content-Type', 'multipart/form-data; charset=UTF-8');
        request.setRequestHeader('Cache-Control', 'no-cache');
        const formData = new FormData();
        formData.append('file', file);
        request.send(formData);
        alert(request.responseText + 'Uploaded file');
    }

    submitClicked() {
        var request = new XMLHttpRequest();
        request.withCredentials = true;
        request.open('POST', 'http://localhost:8080/deliverable/info');
        request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        var data = JSON.stringify({
            deliverableNumber: this.state.deliverableNumber,
            name: this.state.name,
            description: this.state.description,
            projectNumber: this.state.projectNumber
        });
        request.setRequestHeader('Cache-Control', 'no-cache');
        request.send(data);
    }

    render() {
        return (
            <div>
                <Panel>
                    <Panel.Heading>
                        Submit Deliverable
                    </Panel.Heading>
                    <Panel.Body>
                    <Form horizontal={true}>
                        
                        <FormGroup controlId="formHorizontalProjectName">
                            <Col componentClass={ControlLabel} sm={2}>
                                Deliverable Number:
                            </Col>
                            <Col sm={10}>
                                <DropdownButton title={this.state.deliverableNumber} id="dropdown-size-small">
                                    <MenuItem eventKey="1" onClick={e => this.handleDropdownClick(1)}>1</MenuItem>
                                    <MenuItem eventKey="2" onClick={e => this.handleDropdownClick(2)}>2</MenuItem>
                                    <MenuItem eventKey="3" onClick={e => this.handleDropdownClick(3)}>3</MenuItem>
                                    <MenuItem eventKey="4" onClick={e => this.handleDropdownClick(4)}>4</MenuItem>
                                    <MenuItem eventKey="5" onClick={e => this.handleDropdownClick(5)}>5</MenuItem>
                                    <MenuItem eventKey="6" onClick={e => this.handleDropdownClick(6)}>6</MenuItem>
                                    <MenuItem eventKey="7" onClick={e => this.handleDropdownClick(7)}>7</MenuItem>
                                </DropdownButton>
                            </Col>
                        </FormGroup>
                        
                        <FormGroup controlId="formHorizontalProjectName">
                            <Col componentClass={ControlLabel} sm={2}>
                                Deliverable Name:
                            </Col>
                            <Col sm={10}>
                                <FormControl type="text" onChange={e => this.handleChange(e)} value={this.state.name} id="name"/>
                            </Col>             
                        </FormGroup>
                        
                        <FormGroup controlId="formHorizontalReview">
                            <Col componentClass={ControlLabel} sm={2}>
                                Description:
                            </Col>
                            <Col sm={10}>
                                <FormControl componentClass="textarea" onChange={e => this.handleChange(e)} value={this.state.description} id="description"/>
                            </Col>    
                        </FormGroup>
                        
                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={2}>
                                Deliverable:
                            </Col>
                            <Col sm={2}>
                                <input type="file" onChange={e => this.handleFileChange(e)} />
                            </Col>
                        </FormGroup>  

                        <FormGroup>
                            <Col smOffset={2} sm={10}>
                                <Button type="submit" bsStyle="primary" onClick={this.uploadFileClicked}>Submit</Button>
                            </Col>
                        </FormGroup>               
                    </Form>    
                    </Panel.Body>
                    </Panel>
                    <SubmitDeliverables/>
            </div>
        );
    }
}

export default SubmitDeliverable;