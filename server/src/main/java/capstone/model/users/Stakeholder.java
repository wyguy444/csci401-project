package capstone.model.users;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import capstone.model.Project;
import capstone.model.Proposal;

@Entity
public class Stakeholder extends User {
	
	private String organization; //only valid if userType = Stakeholder
	
	@OneToMany(targetEntity=Project.class)
	private Collection<Project> projectIds;
	//@OneToOne(targetEntity=Project.class)
	//private Project project;
	
	@OneToMany(targetEntity=Proposal.class)
	private Collection<Proposal> proposalIds;
	
	private int avgRating;
	
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Collection<Proposal> getProposalIds() {
		return proposalIds;
	}
	public void setProposalIds(Collection<Proposal> proposalIds) {
		this.proposalIds = proposalIds;
	}
	public void setProjectIds(Collection<Project> projectIds) {
		this.projectIds = projectIds;
	}
	public Collection<Project> getProjectIds() {
		return projectIds;
	}
	/*public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}*/
	public int getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}
}