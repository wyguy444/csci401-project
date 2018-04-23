import * as React from 'react';
import PropTypes from 'prop-types';
import ItemTypes from './ItemTypes';
import { DropTarget } from 'react-dnd';
import StudentCard from './StudentCard';
import {
    StudentInfo,
    Project,
} from './index';

interface ProjectCardProps {
    project: Project;
    key: number;
    canDrop?: PropTypes.bool.isRequired;
    connectDropTarget?: PropTypes.func.isRequired;
    moveCard: PropTypes.func.isRequired;
    findCard: PropTypes.func.isRequired;
}

interface ProjectCardState {

}

const cardTarget = {
    canDrop(props: any) {
        return false;
    },

    drop(props: any) {
        return {};
    },

    hover(props: any, monitor: any) {
        const { id: draggedId } = monitor.getItem();
        const { id: overId } = props;

        if (draggedId !== overId) {
            const { index: overIndex } = props.findCard(overId);
            props.moveCard(draggedId, overIndex);
        }
    },
};

function collect(connect: any, monitor: any) {
    return {
        connectDropTarget: connect.dropTarget(),
        isOver: monitor.isOver(),
    };
}

@DropTarget(ItemTypes.STUDENT, cardTarget, collect)
class ProjectCard extends React.Component<ProjectCardProps, ProjectCardState> {
    constructor(props: ProjectCardProps) {
        super(props);
    
        this.state = {
        };
    }
    
    render() {
        const {project, key, connectDropTarget} = this.props;
        return connectDropTarget(
            <tr key={key}>
              <td>{project.projectName}</td>
              <td>{project.minSize}</td>
              <td>{project.maxSize}</td>
              <td>
              {project.members.map((student: StudentInfo) =>
                <StudentCard student={student} key={student.userId} />
              )}
              </td>
            </tr>
        );
    }
}

export default ProjectCard;