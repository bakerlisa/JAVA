rest controller - 
@controller - looks for the file

@requestMapping("/"){
    public string index(){
        return "index.jsp";
    }
}

@restController - looks onlt for html
//Renders the html



---- SENDING INFO ----
public String withcher(Model model){
    model.addAttruibute("name","Geralt");
    return "witcher.jsp";
}


->> witcher.jsp
{$name}
