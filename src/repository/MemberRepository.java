package repository;

import model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private List<Member> members;

    public MemberRepository() {
        this.members= new ArrayList<>();

    }

    public void save(Member member) {
        members.add(member);
    }

    public void delete(String memberId) {
        members.removeIf(m -> m.getId().equals(memberId));
    }

    public Member findById(String id) {
        for(Member m : members){
            if(m.getId().equals(id)){
                return m;
            }
        }
        return null;
    }

    public List<Member> findAll() {
        // return a copy to avoid exposing internal list
        return new ArrayList<>(this.members);
    }

}
  