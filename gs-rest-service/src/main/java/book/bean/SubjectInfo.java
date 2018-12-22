package book.bean;
import java.io.Serializable;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class SubjectInfo implements Serializable,Comparable<SubjectInfo>{
	
	
	private static final long serialVersionUID = 1L;
	private long subjectId;
	private String subtitle;
	private int durationInHours;
	private Set<Book> references;
	
	public SubjectInfo(long subjectId, String subtitle, int durationInHours, Set references) {
		super();
		this.subjectId = subjectId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
		this.references = references;
	}

	public SubjectInfo() {
		
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public Set<Book> getReferences() {
		return references;
	}

	public void setReferences(Set<Book> references) {
		this.references = references;
	}

	@Override
	public int compareTo(SubjectInfo ob) {
		
		return subtitle.compareTo(ob.getSubtitle());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + durationInHours;		
		result = prime * result + (int) (subjectId ^ (subjectId >>> 32));
		result = prime * result + ((subtitle == null) ? 0 : subtitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectInfo other = (SubjectInfo) obj;
		if (durationInHours != other.durationInHours)
			return false;
		if (references != other.references)
			return false;
		if (subjectId != other.subjectId)
			return false;
		if (subtitle == null) {
			if (other.subtitle != null)
				return false;
		} else if (!subtitle.equals(other.subtitle))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuffer str=new StringBuffer("\nSubject Id:"+subjectId+"\nSub title:"+subtitle+"\nDuration in hours:"+durationInHours
				+"\nList of reference Book:\n");
		for(Book book:references) {
			str.append(book.toString());
		}
		
		return str.toString();
	}
	
	

}
