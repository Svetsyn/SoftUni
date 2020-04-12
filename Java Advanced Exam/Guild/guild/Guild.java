package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }
    public boolean removePlayer(String name){
        boolean removed = this.roster.removeIf(e->e.getName().equals(name));
        return removed;
    }
    public void promotePlayer(String name){
        int index=-1;
        for (int i = 0; i < this.roster.size(); i++) {
            String promot=this.roster.get(i).getName();
            if (promot.equals(name)){
                if (this.roster.get(i).getRank().equals("Trial")){
                    this.roster.get(i).setRank("Member");
                    index++;
                    break;
                }
                if (index!=-1){
                    break;
                }
            }
        }
    }
    public void demotePlayer(String name){
        int index=-1;
        for (int i = 0; i < this.roster.size(); i++) {
            String demote =this.roster.get(i).getName();
            if (demote.equals(name)){
                if (this.roster.get(i).getRank().equals("Member")){
                    this.roster.get(i).setRank("Trial");
                    index++;
                    break;
                }
                if (index!=-1){
                    break;
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] removed = roster.stream()
                .filter(player -> clazz.equals(player.getClazz()))
                .toArray(Player[]::new);

        for (Player player : removed) {
            roster.remove(player);
        }

        return removed;
    }

    public int count(){
        int sum = this.roster.size();
        return sum;
    }

    public String report(){
        StringBuilder sb =new StringBuilder(String.format("Players in the guild: %s:%n",this.name));
        for (Player player : roster) {
            sb.append(player).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
