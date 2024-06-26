
package poetodoapp;

import javax.swing.JOptionPane;


public class ToDo {
     //Variable declarations
    private String Taskname;
    private String TaskNumber;
    private String TaskDescription;
    private String Details;
    private int Duration;
    private String TaskID;
    private String TaskStatus;
    private int sum =0;
    
    //Array Declarations
    static String[] arrDeveloper = new String[20];
    static String[] arrTaskName = new String[20];
    static String[] arrTaskID = new String[20];
    static String[] arrTaskDuration = new String[20];
    static String [] arrTaskStatus = new String [20];
    
    public void populateArray()
    {
        int position = TaskNumber;
      
      arrDeveloper[position] = Details;
      arrTaskDuration[position] = Duration;
      arrTaskName[position]= Taskname;
      arrTaskID[position] = TaskID;
      arrTaskStatus[position] = TaskStatus;
       
      
      
      
    }
    
    public void DisplayArray()
    {
        String output ="";
        
        for (int i=0, i<= TaskNumber, i++)
        {
        output += "Task Name:\t" + arrTaskName[i];
        output += "\nTask Numer:\t" + i;
        output += "\nTask ID:\t" + arrTaskID[i];
        output += "\nTask Duration:\t" + arrTaskDuration[i];
        output += "\nTask Status:\t" + arrTaskStatus[i];
                }  
        JOptionPane.showMessageDialog(null,output);
    }
    
    public void SearchArray()
    {
        boolean found = false;
        
       for (int i=0, i<= TaskNumber, i++)
       {
           if (arrTaskName[i].equalsIgnoreCase(Taskname))
           {
              String output+= "Task Name:\t" + arrTaskName[i];
              output += "\nTask Numer:\t" + i;
              output += "\nTask ID:\t" + arrTaskID[i];
              output += "\nTask Duration:\t" + arrTaskDuration[i];
              output += "\nTask Status:\t" + arrTaskStatus[i]; 
              
              JOptionPane.showMessageDialog(null,output);
              found = true;
           }
           if (!found)
           {
               JOptionPane.showMessageDialog(null,"Task Name Not Found! Please Try Again!");
               
           }
       }
        
       

        }
        public void RemoveTask(String TaskName)
        {
          String[] tempAarrTaskName = new String [TaskNumber+1];
          String[] tempAarrTaskID = new String [TaskNumber+1];
          String[] tempAarrDescription = new String [TaskNumber+1];
          String[] tempAarrDuration = new String [TaskNumber+1];
          String[] tempAarrTaskStatus = new String [TaskNumber+1];
          
          int j =0;
          boolean removed = false;
          
          
          for (int i=0, i<= TaskNumber, i++)
          {
              if (!(arrTaskName[i].equalsIgnoreCase(TaskName)))
              {
                  tempAarrDuration[j]= arrTaskDuration[i];
                  tempAarrTaskID[j]= arrTaskID[i];
                  tempAarrTaskName[j]= arrTaskName[i];
                  tempAarrTaskStatus[j]= arrTaskStatus[i];
                  j++;
                  
                  
                  
              }
              else {removed =true;}
              
          }
          if (!removed)
          {
              JOptionPane.showMessageDialog(null, "Task could not be removed! Please try again");
          }
          else
          {
              arrTaskDuration=tempAarrDuration;
              arrTaskID=tempAarrTaskID;
              arrTaskName=tempAarrTaskName;
              arrTaskStatus=tempAarrTaskStatus;
              
             JOptionPane.showMessageDialog(null, "Task removed successfully");
             
          }
          
          
          
    }
    public void addTask (String Taskname, String TaskNumber, String TaskDescription, String Details, int Duration, String TaskID, String TaskStatus)
    {
        
        this.Taskname = Taskname;
        this.TaskNumber = TaskNumber;
        checkDescription(TaskDescription);
        this.Details = Details;
        this.Duration = Duration;
        CreateTaskID(Taskname,TaskNumber,Details);
        this.TaskStatus= TaskStatus;
        
        
    }        

    private boolean checkDescription(String TaskDescription)
    {
       if (TaskDescription.length() <= 100)
       {
           return true;
       }
       else return false;
    }

    private String CreateTaskID(String Taskname, String TaskNumber, String DeveloperName) 
    {
       String Output;
       
       if (DeveloperName.contains(" ") &&  Taskname.length()>2)
       {
           int space = DeveloperName.indexOf(" ");
           
           String developerID = DeveloperName.substring(space-2, space).toUpperCase();
           String NameID= Taskname.substring(0,2).toUpperCase();
           
           Output = NameID + "#" + TaskNumber + "#" + developerID;
           TaskID = Output;
       }
       else
       {
           JOptionPane.showMessageDialog(null,"An Error has occurred.");
       }
       return TaskID;
    }
    
    public String PrintTaskDetails()
    {
        StringBuilder display = new StringBuilder();
        display.append("\nStatus: ").append(TaskStatus);
        display.append("\nDeveloper Details: ").append(Details);
        display.append("\nTask Number: ").append(TaskNumber);
        display.append("\nTask Name: ").append(Taskname);
        display.append("\nTask Description: ").append(TaskDescription);
        display.append("\nTask ID: ").append(TaskID);
        display.append("\nTask Duration").append(Duration);
        
        return display.tostring();
    }
      
    public int ReturnTotalHours(int Duration)
    {
        sum+= Duration;
        Duration = sum;
                return sum;
    }
    
     public String CalculateStatus(int TaskStat)
    {
        while(true)
        {
            switch (TaskStat)
            {
                case 1:
                    TaskStatus = "TO DO";
                    break;
                    
                case 2:
                    TaskStatus = "Done";
                    break;
                    
                case 3:
                    TaskStatus = "Doing";
                    break;
                    
                default:
                    //JOptionPane.showMessageDialog(null, "The value you have entered is incorrect. Please enter a number.");
                    TaskStat= Integer.parseInt(JOptionPane.showInputDialog("Please enter the status of the Task: \n1. TO DO\n2. DONE\n3. DOING"));
                    break;
            }
        }
    }
      public void TaskMenu()
    {
        int option = Integer.parseInt(JOptionPane.showInputDialog("Please select an option: \n1. Add Task\n2. Show Tasks\n 3. Quit"));
        
        while(!(option == 3))
        {
            try
            {
                switch(option)
                {
                    case 1:
                        int numTasks =Integer.parseInt(JOptionPane.showInputDialog("How many Tasks would you like to enter?"));
                        
                    {
                        int numTask = 0;
                        for(int x=0; x< numTask; x++)
                        {

                            //user enters the name of the Task
                            String  TaskName= JOptionPane.showInputDialog("Please enter the name of the Task");
                            
                            //user enters the Task number
                            String TaskNumber = JOptionPane.showInputDialog("Please enter the Task number of " + TaskName);
                            //user enters the first name and last name of the author
                            String DeveloperDetails = JOptionPane.showInputDialog("Please enter the author of  " + TaskName);
                            
                            //user enters the reading duration of the Task
                            int duration = Integer.parseInt(JOptionPane.showInputDialog("Please enter the estimated duration of " + TaskName + " (hours)"));
                                    
                            //user enters the status of the Task
                            String tStatus = JOptionPane.showInputDialog("Please enter the status of the Task:\n1. On my bookshelf\n2. Completed\n3. Currently reading");

                            //user enters a brief description of the Task
                            String description = JOptionPane.showInputDialog("Please enter a brief description of  " + TaskName);
                            
                            //checks if the description meets the requirements
                            if(CheckDescription(TaskDescription))
                            {
                                JOptionPane.showMessageDialog(null, "Task successfully captured");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Please enter a brief description of  " + TaskName + "(please ensure it is less that 100 characters)");
                            }
                            
                            addTask(TaskName, TaskNumber, description, DeveloperDetails, duration, TaskID, tStatus);
                            JOptionPane.showMessageDialog(null, PrintTaskDetails());
                        }
                    }
                        break;

                        
                    case 2:
                        
                        break;
                        
                    case 3:
                        System.exit(0);
                        break;
                        
                    default:
                        System.exit(0);
                }
            }
            catch(NumberFormatException n)
            {
                JOptionPane.showInputDialog(null, "Error: " + n + " Invalid value please enter a number");
            }
           
            option = Integer.parseInt(JOptionPane.showInputDialog("Please select an option: \n1. Add Task\n2. Show Report\n 3. Quit"));

        }
    }

    private boolean CheckDescription(String TaskDescription) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
