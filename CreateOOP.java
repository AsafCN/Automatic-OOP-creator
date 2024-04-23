import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class CreateOOP {
    Scanner in = new Scanner(System.in);


    // ---=== All The Fields That Are In The OOP ===---
    private String _name;

    private String _extends_check = "";

    private String _to_be_extended_check = "";

    private boolean _to_be_extended_check_true_false;

    private String _extends_check_yes;

    private boolean _extends_check_true_false;

    private String _fin_extends;

    private int _num_of_fields;

    private String _fin_getters = "\n\n    //getters ";

    private String _fin_setters = "\n    //setters ";
    private List<String> _getters_list = new ArrayList<String>();

    private String _field_name;

    private String _field_capitalized_name;

    private List<String> _fields_types_list = new ArrayList<String>();

    private List<String> _fields_names_list = new ArrayList<String>();

    private List<String> _fields_capitalized_names_list = new ArrayList<String>();

    private String _field_type = "";

    private String _fields_for_const = "";

    private String _extended_fields_for_const = "";

    private String _fin_fields = "";

    private String _fin_Const = "";

    private String _inside_const = "";

    private String _super_for_const = "";

    private String _extended_inside_const = "";

    private int _extended_num_of_fildes ;

    private List<String> _fields_extended_types_list = new ArrayList<String>();

    private List<String> _fields_extended_names_list = new ArrayList<String>();

    private List<String> _fields_extended_capitalized_names_list = new ArrayList<String>();

    private String _inside_to_string = "";

    private String _fin_to_string = "";

    private String _fin_OOP = "";

    //const
    public CreateOOP() {
        setName();
        setExtends();
        setFields();
        setGetters();
        setSetters();
        setConst();
        setToString();
        setOOP();
    }

    //adders

    private void AddFieldName(String adding) {
        _fields_names_list.add(adding);
    }

    private void AddCapitalizedFieldName(String adding) {
        _fields_capitalized_names_list.add(adding);
    }

    private void AddFieldType(String adding) {
        _fields_types_list.add(adding);
    }

    private void AddExtendedFieldName(String adding) {
        _fields_extended_names_list.add(adding);
    }

    private void AddExtendedCapitalizedFieldName(String adding) {
        _fields_extended_capitalized_names_list.add(adding);
    }

    private void AddExtendedFieldType(String adding) {
        _fields_extended_types_list.add(adding);
    }


    //getters
    public String Name(){ // returning the const name
        return _name;
    }
    public int NumOfFileds(){ // returning the num of the fields
        return _num_of_fields;
    }
    public int ExtendedNumOfFields(){
        return _extended_num_of_fildes;
    }

    public String CapitalizedFieldsName(int i) {
        return _fields_capitalized_names_list.get(i);
    }

    public String CapitalizedExtendedFieldsName(int i){
        return _fields_extended_capitalized_names_list.get(i);
    }

    public String FieldsName(int i) {
        return _fields_names_list.get(i);
    }

    public String ExtendedFieldsName(int i) {
        return _fields_extended_names_list.get(i);
    }

    public String FieldsType(int i) {
        return _fields_types_list.get(i);
    }

    public String ExtendedFieldsType(int i) {
        return _fields_extended_types_list.get(i);
    }

    public List<String> GettersList() {
        return _getters_list;
    }

    // setters

    private void setName(){
        System.out.println("What is your class name? ");
        String name = in.nextLine();
        _name = name;
    }

    private void setNumOfFields(){
        NumOfFieldsCheck();
        int num_of_fields = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("How many fields do you want?");
            try {
                num_of_fields = in.nextInt();
                if (num_of_fields >= 1) {
                    _num_of_fields = num_of_fields;
                    validInput = true;
                } else {
                    System.out.println("Enter a valid number of fields (should be at least 1).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                in.next();
            }
        }
    }

    private void setExtends(){
        boolean validInput = false;
        while (!validInput) { // while the validInput equals to true
            System.out.println("Do you want to extends other class?");
            _extends_check = in.next();
            if (_extends_check.equals("no") || _extends_check.equals("No") || _extends_check.equals("false") || _extends_check.equals("False")) { // if he doesnt want to extends other class
                _fin_extends = "public class " + _name + "{\n   ";
                _extends_check_true_false = false;
                _to_be_extended_check_true_false = true;
                validInput = true;
            }
            else if (_extends_check.equals("yes") || _extends_check.equals("Yes") || _extends_check.equals("true") || _extends_check.equals("True")) { // if he does want to extends other class
                System.out.println("What is the name of the class you want to extend? ");
                _extends_check_yes = in.next();
                _extends_check_true_false = true;
                _to_be_extended_check_true_false = false;
                _fin_extends = "public class " + _name + " extends " + _extends_check_yes + "{\n   ";
                validInput = true;
            }
            else {
                System.out.println("Enter a valid answer");
            }
        }
        if (!_extends_check_true_false){
            validInput = false;
            while (!validInput) { // while the validInput equals to true
                System.out.println("Do you want this class to be extended? (father)");
                _to_be_extended_check = in.next();
                if (_to_be_extended_check.equals("no") || _to_be_extended_check.equals("No") || _to_be_extended_check.equals("false") || _to_be_extended_check.equals("False")) { // if he doesnt want to extends other class
                    _to_be_extended_check_true_false = false;
                    validInput = true;
                }
                else if (_to_be_extended_check.equals("yes") || _to_be_extended_check.equals("Yes") || _to_be_extended_check.equals("true") || _to_be_extended_check.equals("True")) { // if he does want to extends other class
                    _to_be_extended_check_true_false = true;
                    validInput = true;
                }
                else {
                    System.out.println("Enter a valid answer");
                }
            }
        }
    }

    private void setGetters(){
        for(int i = 0;i<NumOfFileds();i++) { // doing a for to all the fields
            _getters_list.add(FieldsName(i)); // adding to the getters list the name of the i field
            _fin_getters += "\n    public " + FieldsType(i) + " " + capitalizeAndRemoveUnderscores(CapitalizedFieldsName(i)) + "() {\n        return " + "_" + FieldsName(i) + ";\n    }\n"; // making the getters String
        }
    }

    private void setSetters() {
        for (int i = 0; i < NumOfFileds(); i++) { // doing a for to all the fields

            if (FieldsType(i).equals("int") || FieldsType(i).equals("double")) { // if the fields type is an int or double
                _fin_setters += "\n    private void set" + capitalizeAndRemoveUnderscores(FieldsName(i)) + "(" + FieldsType(i) + " " + FieldsName(i) + ") {" +
                        "\n       if (" + FieldsName(i) + " < 0) {\n" +
                        "            _" + FieldsName(i) + " = 0;\n" +
                        "       } else {\n" +
                        "            _" + FieldsName(i) + " = " + FieldsName(i) + ";\n" +
                        "       }" +
                        "\n    }"; // making the setters String to the i field and the i field type
            } else if (FieldsType(i).equals("String")) { // if the fields type is String
                _fin_setters += "\n    private void set" + capitalizeAndRemoveUnderscores(FieldsName(i)) + "(" + FieldsType(i) + " " + FieldsName(i) + ") {" +
                        "\n       if (" + FieldsName(i) + ".isEmpty()) {\n" +
                        "            _" + FieldsName(i) + " = \"None\";\n" +
                        "       } else {\n" +
                        "            _" + FieldsName(i) + " = " + FieldsName(i) + ";\n" +
                        "       }" +
                        "\n    }"; // making the setters String to the i field and the i field type
            } else if (FieldsType(i).equals("boolean")) { // if the fields type is boolean
                _fin_setters += "\n    private void set" + capitalizeAndRemoveUnderscores(FieldsName(i)) + "(" + FieldsType(i) + " " + FieldsName(i) + ") {" +
                        "\n       _" + FieldsName(i) + " = " + FieldsName(i) + ";\n" +
                        "    }"; // making the setters String to the i field and the i field type
            }
        }

    }

    private void setConst() {
        for (int i = 0;i<NumOfFileds();i++){  // doing a for loop to the inside of the const
            _inside_const += "\n        set" + capitalizeAndRemoveUnderscores(FieldsName(i)) +"(" + FieldsName(i) + ");"; // adding to the _inside_const the String
        }

        for (int i = 0; i<ExtendedNumOfFields();i++){
            _extended_fields_for_const += ExtendedFieldsType(i) + " " + ExtendedFieldsName(i) + ", ";
        }

        for (int i = 0; i<ExtendedNumOfFields();i++){
            _super_for_const += ExtendedFieldsName(i) + ", " ;
        }

        if (_extends_check_true_false){
            _super_for_const = RemoveLastLetter(_super_for_const);
            _fin_Const = "public " + Name() + "(" + _extended_fields_for_const + _fields_for_const + "){          " + "\n        super(" + _super_for_const + ");"+ _inside_const + "\n    }"; // making the finished const String
        }
        else {
            _fin_Const = "public " + Name() + "(" + _fields_for_const + "){          " + _inside_const + "\n    }"; // making the finished const String
        }

    }

    private void setFields() {
        if (_to_be_extended_check_true_false){
            ProtectedFieldCheck();
        }
        else{
            NormalFieldCheck();
        }

        _fields_for_const = RemoveLastLetter(_fields_for_const); // removing the , from the last char of the string
    }

    private void setToString() {
        for (int i = 0; i<NumOfFileds();i++) {
            _inside_to_string += "        \"" + ReplaceUnderscoresWithSpaces(CapitalizedFieldsName(i)) + ": \" +  _" + FieldsName(i) + " +\n";
        }
        _inside_to_string = RemoveLastLetter(_inside_to_string);
        _fin_to_string += "\n\n    public String toString() {\n" +
                "        return " +
                "\"Your Details: \" + \n" + _inside_to_string + "; \n    }";
    }

    private void setOOP() {
        _fin_OOP = _fin_extends +
                _fin_fields + " " + _fin_Const + _fin_getters + _fin_setters + _fin_to_string + "\n}"; // adding the class ,const, getters and setters to the field _fin_OOP

        //---=== Making The file ===---

        String currentDirectory = System.getProperty("user.dir");
        String fileName = currentDirectory + "\\src\\" + Name() + ".java"; // making the file name to a spacific path

        String fileContent = _fin_OOP; // adding the whole Content of the file

        // Write the content to the file
        try { // check on Google I took it from Google
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(fileContent);
            printWriter.close();
            System.out.println("Java file '" + fileName + "' created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating Java file: " + e.getMessage());
        }
    }

    private void NumOfFieldsCheck() {
        boolean validInput = false;
        int num_of_fields = 0;
        if (_extends_check_true_false) {
            while (!validInput) { // while the validInput equals to true
                try {
                    System.out.println("How many fields you have in the extended class?");
                    num_of_fields = in.nextInt();
                    if (num_of_fields >= 1) {
                        _extended_num_of_fildes = num_of_fields;
                        validInput = true;
                    } else {
                        System.out.println("Enter a valid number of fields (should be at least 1).");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid integer.");
                    in.next();
                }
            }

            validInput = false;
            while (!validInput) { // while the validInput equals to true
                System.out.println("What is the field name you have in the extended class?");
                _field_name = in.nextLine();
                _field_name += in.nextLine();
                _field_name = ReplaceSpacesWithUnderScores(_field_name);
                System.out.println("What is the type of the field that you have in the extended class? int | double | String | boolean");
                _field_type = in.next();
                _field_capitalized_name = capitalizeFirstLetter(_field_name); // making the first letter of the field capitalized
                if (_field_type.equals("int")) { // checking if the fields type is int
                    AddExtendedFieldType(_field_type); // adding the field type to the fields type list
                    AddExtendedFieldName(_field_name); // adding the field name to the fields name list
                    AddExtendedCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                } else if (_field_type.equals("double")) { // checking if the fields type is double
                    AddExtendedFieldType(_field_type); // adding the field type to the fields type list
                    AddExtendedFieldName(_field_name); // adding the field name to the fields name list
                    AddExtendedCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                } else if (_field_type.equals("String") || _field_type.equals("string")) { // checking if the fields type is String
                    _field_type = "String";
                    AddExtendedFieldType(_field_type); // adding the field type to the fields type list
                    AddExtendedFieldName(_field_name); // adding the field name to the fields name list
                    AddExtendedCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list                        _fields_for_const += "String " + _field_name + ", "; // making the fields for the inside of the () in the const
                } else if (_field_type.equals("boolean") || _field_type.equals("bool")) { // checking if the fields type is boolean
                    _field_type = "boolean";
                    AddExtendedFieldType(_field_type); // adding the field type to the fields type list
                    AddExtendedFieldName(_field_name); // adding the field name to the fields name list
                    AddExtendedCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list                        _fields_for_const += "boolean " + _field_name + ", "; // making the fields for the inside of the () in the const
                }
                if (_field_type.equals("int") || _field_type.equals("double") || _field_type.equals("String") || _field_type.equals("string") || _field_type.equals("boolean") || _field_type.equals("bool")) {
                    for (int i = 1; i < _extended_num_of_fildes; i++) { // dong a for loop to the number of the field that the user entered
                        System.out.println("Enter another field name?");
                        _field_name = in.nextLine();
                        _field_name += in.nextLine();
                        _field_name = ReplaceSpacesWithUnderScores(_field_name);
                        System.out.println("Enter another type of field that " + _field_name + " will be? int | double | String | boolean");
                        _field_type = in.next();
                        _field_capitalized_name = capitalizeFirstLetter(_field_name); // making the first letter of the field capitalized
                        if (_field_type.equals("int")) { // checking if the fields type is int
                            AddExtendedFieldType(_field_type); // adding the field type to the fields type list
                            AddExtendedFieldName(_field_name); // adding the field name to the fields name list
                            AddExtendedCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list                                _fields_for_const += "int " + _field_name + ", "; // making the fields for the inside of the () in the const
                        } else if (_field_type.equals("double")) { // checking if the fields type is double
                            AddExtendedFieldType(_field_type); // adding the field type to the fields type list
                            AddExtendedFieldName(_field_name); // adding the field name to the fields name list
                            AddExtendedCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list                                _fields_for_const += "double " + _field_name + ", "; // making the fields for the inside of the () in the const
                        } else if (_field_type.equals("String") || _field_type.equals("string")) { // checking if the fields type is String
                            _field_type = "String";
                            AddExtendedFieldType(_field_type); // adding the field type to the fields type list
                            AddExtendedFieldName(_field_name); // adding the field name to the fields name list
                            AddExtendedCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list                                _fields_for_const += "String " + _field_name + ", "; // making the fields for the inside of the () in the const
                        } else if (_field_type.equals("boolean") || _field_type.equals("bool")) { // checking if the fields type is boolean
                            _field_type = "boolean";
                            AddExtendedFieldType(_field_type); // adding the field type to the fields type list
                            AddExtendedFieldName(_field_name); // adding the field name to the fields name list
                            AddExtendedCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list                                _fields_for_const += "boolean " + _field_name + ", "; // making the fields for the inside of the () in the const
                        }
                    }
                    validInput = true; // stoping the while loop
                } else { // if the user didn`t entered a valid type its telling him to enter again
                    System.out.println("Enter a valid type of field");
                    _field_type = in.next();
                }
            }
        }
    }

    private void ProtectedFieldCheck() {
        boolean validInput = false; // setting the while to false
        setNumOfFields();
        while (!validInput) { // while the validInput equals to true
            System.out.println("What is your field name?");
            _field_name = in.nextLine();
            _field_name += in.nextLine();
            _field_name = ReplaceSpacesWithUnderScores(_field_name);
            System.out.println("What you want the type of the field will be? int | double | String | boolean");
            _field_type = in.next();
            _field_capitalized_name = capitalizeFirstLetter(_field_name); // making the first letter of the field capitalized
            if (_field_type.equals("int")) { // checking if the fields type is int
                AddFieldType(_field_type); // adding the field type to the fields type list
                AddFieldName(_field_name); // adding the field name to the fields name list
                AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                _fields_for_const += "int " + _field_name + ", "; // making the fields for the inside of the () in the const
                _fin_fields += " protected int _" + _field_name + ";\n   "; // making the finished fields String
            } else if (_field_type.equals("double")) { // checking if the fields type is double
                AddFieldType(_field_type); // adding the field type to the fields type list
                AddFieldName(_field_name); // adding the field name to the fields name list
                AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                _fields_for_const += "double " + _field_name + ", "; // making the fields for the inside of the () in the const
                _fin_fields += " protected double _" + _field_name + ";\n   "; // making the finished fields String
            } else if (_field_type.equals("String") || _field_type.equals("string")) { // checking if the fields type is String
                _field_type = "String";
                AddFieldType(_field_type); // adding the field type to the fields type list
                AddFieldName(_field_name); // adding the field name to the fields name list
                AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                _fields_for_const += "String " + _field_name + ", "; // making the fields for the inside of the () in the const
                _fin_fields += " protected String _" + _field_name + ";\n   "; // making the finished fields String
            } else if (_field_type.equals("boolean")) { // checking if the fields type is boolean
                AddFieldType(_field_type); // adding the field type to the fields type list
                AddFieldName(_field_name); // adding the field name to the fields name list
                AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                _fields_for_const += "boolean " + _field_name + ", "; // making the fields for the inside of the () in the const
                _fin_fields += " protected boolean _" + _field_name + ";\n   "; // making the finished fields String
            }
            if (_field_type.equals("int") || _field_type.equals("double") || _field_type.equals("String") || _field_type.equals("boolean")) {
                for (int i = 1; i < NumOfFileds(); i++) { // dong a for loop to the number of the field that the user entered
                    System.out.println("Enter another field name?");
                    _field_name = in.nextLine();
                    _field_name += in.nextLine();
                    _field_name = ReplaceSpacesWithUnderScores(_field_name);
                    System.out.println("Enter another type of field that " + _field_name + " will be? int | double | String | boolean");
                    _field_type = in.next();
                    _field_capitalized_name = capitalizeFirstLetter(_field_name); // making the first letter of the field capitalized
                    if (_field_type.equals("int")) { // checking if the fields type is int
                        AddFieldType(_field_type); // adding the field type to the fields type list
                        AddFieldName(_field_name); // adding the field name to the fields name list
                        AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                        _fields_for_const += "int " + _field_name + ", "; // making the fields for the inside of the () in the const
                        _fin_fields += " protected int _" + _field_name + ";\n   "; // making the finished fields String
                    } else if (_field_type.equals("double")) { // checking if the fields type is double
                        AddFieldType(_field_type); // adding the field type to the fields type list
                        AddFieldName(_field_name); // adding the field name to the fields name list
                        AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                        _fields_for_const += "double " + _field_name + ", "; // making the fields for the inside of the () in the const
                        _fin_fields += " protected double _" + _field_name + ";\n   "; // making the finished fields String
                    } else if (_field_type.equals("String") || _field_type.equals("string")) { // checking if the fields type is String
                        _field_type = "String";
                        AddFieldType(_field_type); // adding the field type to the fields type list
                        AddFieldName(_field_name); // adding the field name to the fields name list
                        AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                        _fields_for_const += "String " + _field_name + ", "; // making the fields for the inside of the () in the const
                        _fin_fields += " protected String _" + _field_name + ";\n   "; // making the finished fields String
                    } else if (_field_type.equals("boolean") || _field_type.equals("bool")) { // checking if the fields type is boolean
                        _field_type = "boolean";
                        AddFieldType(_field_type); // adding the field type to the fields type list
                        AddFieldName(_field_name); // adding the field name to the fields name list
                        AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                        _fields_for_const += "boolean " + _field_name + ", "; // making the fields for the inside of the () in the const
                        _fin_fields += " protected boolean _" + _field_name + ";\n   "; // making the finished fields String
                    }
                }
                validInput = true; // stoping the while loop
            } else { // if the user didn`t entered a valid type its telling him to enter again
                System.out.println("Enter a valid type of field");
                _field_type = in.next();
            }
        }
    }

    private void NormalFieldCheck() {
        boolean validInput = false; // setting the while to false
        setNumOfFields();
        while (!validInput) { // while the validInput equals to true
            System.out.println("What is your field name?");
            _field_name = in.nextLine();
            _field_name += in.nextLine();
            _field_name = ReplaceSpacesWithUnderScores(_field_name);
            System.out.println("What you want the type of the field will be? int | double | String | boolean");
            _field_type = in.next();
            _field_capitalized_name = capitalizeFirstLetter(_field_name); // making the first letter of the field capitalized
            if (_field_type.equals("int")) { // checking if the fields type is int
                AddFieldType(_field_type); // adding the field type to the fields type list
                AddFieldName(_field_name); // adding the field name to the fields name list
                AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                _fields_for_const += "int " + _field_name + ", "; // making the fields for the inside of the () in the const
                _fin_fields += " private int _" + _field_name + ";\n   "; // making the finished fields String
            } else if (_field_type.equals("double")) { // checking if the fields type is double
                AddFieldType(_field_type); // adding the field type to the fields type list
                AddFieldName(_field_name); // adding the field name to the fields name list
                AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                _fields_for_const += "double " + _field_name + ", "; // making the fields for the inside of the () in the const
                _fin_fields += " private double _" + _field_name + ";\n   "; // making the finished fields String
            } else if (_field_type.equals("String") || _field_type.equals("string")) { // checking if the fields type is String
                _field_type = "String";
                AddFieldType(_field_type); // adding the field type to the fields type list
                AddFieldName(_field_name); // adding the field name to the fields name list
                AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                _fields_for_const += "String " + _field_name + ", "; // making the fields for the inside of the () in the const
                _fin_fields += " private String _" + _field_name + ";\n   "; // making the finished fields String
            } else if (_field_type.equals("boolean")) { // checking if the fields type is boolean
                AddFieldType(_field_type); // adding the field type to the fields type list
                AddFieldName(_field_name); // adding the field name to the fields name list
                AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                _fields_for_const += "boolean " + _field_name + ", "; // making the fields for the inside of the () in the const
                _fin_fields += " private boolean _" + _field_name + ";\n   "; // making the finished fields String
            }
            if (_field_type.equals("int") || _field_type.equals("double") || _field_type.equals("String") || _field_type.equals("boolean")) {
                for (int i = 1; i < NumOfFileds(); i++) { // dong a for loop to the number of the field that the user entered
                    System.out.println("Enter another field name?");
                    _field_name = in.nextLine();
                    _field_name += in.nextLine();
                    _field_name = ReplaceSpacesWithUnderScores(_field_name);
                    System.out.println("Enter another type of field that " + _field_name + " will be? int | double | String | boolean");
                    _field_type = in.next();
                    _field_capitalized_name = capitalizeFirstLetter(_field_name); // making the first letter of the field capitalized
                    if (_field_type.equals("int")) { // checking if the fields type is int
                        AddFieldType(_field_type); // adding the field type to the fields type list
                        AddFieldName(_field_name); // adding the field name to the fields name list
                        AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                        _fields_for_const += "int " + _field_name + ", "; // making the fields for the inside of the () in the const
                        _fin_fields += " private int _" + _field_name + ";\n   "; // making the finished fields String
                    } else if (_field_type.equals("double")) { // checking if the fields type is double
                        AddFieldType(_field_type); // adding the field type to the fields type list
                        AddFieldName(_field_name); // adding the field name to the fields name list
                        AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                        _fields_for_const += "double " + _field_name + ", "; // making the fields for the inside of the () in the const
                        _fin_fields += " private double _" + _field_name + ";\n   "; // making the finished fields String
                    } else if (_field_type.equals("String") || _field_type.equals("string")) { // checking if the fields type is String
                        _field_type = "String";
                        AddFieldType(_field_type); // adding the field type to the fields type list
                        AddFieldName(_field_name); // adding the field name to the fields name list
                        AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                        _fields_for_const += "String " + _field_name + ", "; // making the fields for the inside of the () in the const
                        _fin_fields += " private String _" + _field_name + ";\n   "; // making the finished fields String
                    } else if (_field_type.equals("boolean") || _field_type.equals("bool")) { // checking if the fields type is boolean
                        _field_type = "boolean";
                        AddFieldType(_field_type); // adding the field type to the fields type list
                        AddFieldName(_field_name); // adding the field name to the fields name list
                        AddCapitalizedFieldName(_field_capitalized_name); // adding the capitalized field name to the fields name list
                        _fields_for_const += "boolean " + _field_name + ", "; // making the fields for the inside of the () in the const
                        _fin_fields += " private boolean _" + _field_name + ";\n   "; // making the finished fields String
                    }
                }
                validInput = true; // stoping the while loop
            } else { // if the user didn`t entered a valid type its telling him to enter again
                System.out.println("Enter a valid type of field");
                _field_type = in.next();
            }
        }
    }

    public String capitalizeAndRemoveUnderscores(String str) {
        String[] words = str.split("_");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstLetter = Character.toUpperCase(word.charAt(0));
                result.append(firstLetter).append(word.substring(1));
            }
        }

        return result.toString();
    }

    private String ReplaceSpacesWithUnderScores(String str) {
        return str.replace(" ", "_");
    }

    private String ReplaceUnderscoresWithSpaces(String str) {
        return str.replace("_", " ");
    }

    private String RemoveLastLetter(String str){
        return str.substring(0, str.length() - 2); // removing the , from the last char of the string
    }

    private String capitalizeFirstLetter(String str) { // func that making the first letter of something capitalized
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
