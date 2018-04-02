import * as React from 'react';
import {
    Form,
    FormGroup,
    Col,
    FormControl,
    Button,
    ControlLabel,
    Panel
} from 'react-bootstrap';

interface ProjectProps {
}
interface ProjectState {
projectName: string;
projectSize: string;
technologiesExpected: string;
backgroundRequested: string;
projectDescription: string;
}

class ProjectInformation extends React.Component<ProjectProps, ProjectState> {
constructor(props: ProjectProps) {
    super(props);
    this.state = {
    projectName: '',
    projectSize: '',
    technologiesExpected: '',
    backgroundRequested: '',
    projectDescription: ''
    };
    this.submitClicked = this.submitClicked.bind(this);
    this.handleChange = this.handleChange.bind(this);

}
    submitClicked() {
        var request = new XMLHttpRequest();
        request.withCredentials = true;
        request.open('POST', 'http://localhost:8080/projectData/');
        request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        var data = JSON.stringify({
        projectName: this.state.projectName,
        projectSize: this.state.projectSize,
        technologiesExpected: this.state.technologiesExpected,
        backgroundRequested: this.state.backgroundRequested,
        projectDescription: this.state.projectDescription,
        });
        request.setRequestHeader('Cache-Control', 'no-cache');
        request.send(data);
        alert('Your project proposal has been submitted!');
        /*
        fetch('http://localhost:8080/projectData/', {
        method: 'POST',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        },
        body: JSON.stringify({
        projectName: this.state.projectName,
        projectSize: this.state.projectSize,
        technologiesExpected: this.state.technologiesExpected,
        backgroundRequested: this.state.backgroundRequested,
        projectDescription: this.state.projectDescription,
        })
        });
        */
    }
    handleChange(e: any) {
    this.setState({ [e.target.id]: e.target.value });

    }

    render() {
        return (
        <Panel>
        <Panel.Heading>Project Information</Panel.Heading>
        <Panel.Body>
        <Form horizontal={true} >
            <FormGroup controlId="formHorizontalProjectName">
                <Col componentClass={ControlLabel} sm={2}>
                    <b>Project Name</b>
                </Col>
                <Col sm={10}>
                <FormControl
                    type="text"
                    id="projectName"
                    value={this.state.projectName}
                    onChange={e => this.handleChange(e)}
                    placeholder="Project Name"
                />
                </Col>
            </FormGroup>

            <FormGroup controlId="formHorizontalNumberStudents">
                <Col componentClass={ControlLabel} sm={2}>
                    <b>Number of Students</b>
                </Col>
                <Col sm={10}>
                <FormControl
                    type="text"
                    id="projectSize"
                    placeholder="Number of Students"
                    onChange={e => this.handleChange(e)}
                    value={this.state.projectSize}
                />
                </Col>
            </FormGroup>
            
            <FormGroup controlId="formHorizontalTechnologies">
                <Col componentClass={ControlLabel} sm={2}>
                    <b>Technologies Expected</b>
                </Col>
                <Col sm={10}>
                <FormControl
                    type="text"
                    id="technologiesExpected"
                    value={this.state.technologiesExpected}
                    placeholder="Technologies expected"
                    onChange={e => this.handleChange(e)}
                />
                </Col>
            </FormGroup>
            
            <FormGroup controlId="formHorizontalBackground">
                <Col componentClass={ControlLabel} sm={2}>
                    <b>Background Requested</b>
                </Col>
                <Col sm={10}>
                <FormControl
                    type="text"
                    id="backgroundRequested"
                    value={this.state.backgroundRequested}
                    placeholder="Background requested"
                    onChange={e => this.handleChange(e)}
                />
                </Col>
            </FormGroup>
            
            <FormGroup controlId="formHorizontalDescription">
                <Col componentClass={ControlLabel} sm={2}>
                    <b>Description</b>
                </Col>
                <Col sm={10}>
                <FormControl
                    componentClass="textarea"
                    type="text"
                    id="projectDescription"
                    value={this.state.projectDescription}
                    placeholder="Description"
                    onChange={e => this.handleChange(e)}
                />
                </Col>
            </FormGroup>

            <FormGroup>
                <Col smOffset={2} sm={10}>
                <Button type="submit" onClick={this.submitClicked}>Edit/Save</Button>
                </Col>
            </FormGroup>
        </Form>
        </Panel.Body>
        </Panel>
        );

    }
}

export default ProjectInformation;