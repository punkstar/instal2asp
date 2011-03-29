package uk.ac.bath.cs.agents.instal2asp;

import java.util.ArrayList;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.JCommander;

public class CommandLine {
    
    protected JCommander _optparse;
    
    @Parameter
    protected ArrayList<String> _parameters = new ArrayList<String>();
    
    @Parameter(names = "--debug", description = "Debug mode")
    protected boolean _debug = false;

    @Parameter(names = {"--help", "-h", "-?"}, description = "Show usage information")    
    protected boolean _help = false;
    
    public static void main(String[] argv) {
        CommandLine c = new CommandLine();
        c.start(new JCommander(c, argv));
    }
    
    public CommandLine() {
        
    }
    
    public void start(JCommander args) {
        this._optparse = args;
        
        if (this._help) {
            this._optparse.usage();
            System.exit(0);
        }
    }
    
    protected void _log(String message) {
        System.err.println(String.format("instal2asp: %s", message));
    }
}

