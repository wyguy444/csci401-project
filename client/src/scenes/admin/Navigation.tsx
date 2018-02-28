import * as React from 'react';
import {
  Route,
  NavLink,
  HashRouter
} from 'react-router-dom';
import UserManagement from './UserManagement/index';
import ProjectProposals from './ProjectProposals/index';
import ClassOverview from './ClassOverview/index';
import Stakeholders from './Stakeholders/index';
import ProjectMatching from './ProjectMatching/index';

class Navigation extends React.Component {
  render() {
    return (
      <HashRouter>
        <div>
            <ul className="header">
              <li><NavLink to="/">Home</NavLink></li>
              <li><NavLink to="/users">User Management</NavLink></li>
              <li><NavLink to="/proposals">Project Proposals</NavLink></li>
              <li><NavLink to="/class">Class Overview</NavLink></li>
              <li><NavLink to="/stakeholders">Stakeholders</NavLink></li>
              <li><NavLink to="/matching">Project Matching</NavLink></li>
            </ul>
          <div className="content">
            <Route path="/users" component={UserManagement}/>
            <Route path="/proposals" component={ProjectProposals}/>
            <Route path="/class" component={ClassOverview}/>
            <Route path="/stakeholders" component={Stakeholders}/>
            <Route path="/matching" component={ProjectMatching}/>
          </div>
        </div>
      </HashRouter>
    );
  }
}

export default Navigation;