

public class QuestionBean  implements java.io.Serializable {
	    
	    protected int    Q_no  = 0;
	    protected String Question    = null;
	    protected String option1 = null;
	    protected String option2  = null;
	    protected String option3 = null;
	    protected String option4 = null;
	    protected String Correct_option = null;

	    public int getQuestionNum() {
	        return Q_no;
	    }
	    public String getQuestion() {
	        return Question;
	    }


	    public String getOption1() {
	        return option1;
	    }
	    public String getOption2() {
	        return option2;
	    }
	    public String getOption3() {
	        return option3;
	    }
	    public String getOption4() {
	        return option4;
	    }
	    public String getCorrectAns() {
	        return Correct_option;
	    }

}
