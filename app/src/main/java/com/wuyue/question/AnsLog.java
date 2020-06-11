package com.wuyue.question;

class AnsLog {

    private String reward;
    private String timelimit;
    private String question;
    private String[] labels;
    private String answer;
    private String follow;

    public AnsLog(){}

    public AnsLog(String reward, String timelimit, String question, String[] labels, String answer, String follow) {
        this.reward = reward;
        this.timelimit = timelimit;
        this.question = question;
        this.labels = labels;
        this.answer = answer;
        this.follow = follow;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }
}
