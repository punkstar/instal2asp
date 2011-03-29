package uk.ac.bath.cs.agents.instal2asp;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import java.io.File;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.JCommander;

public class CommandLine {
    
    protected JCommander _optparse;
    
    @Parameter(description = "<InstAL specification>+")
    protected List<String> _files = new ArrayList<String>();
    
    @Parameter(names = "--debug", description = "Debug mode")
    protected boolean _debug = false;

    @Parameter(names = {"--help", "-h", "-?"}, description = "Show usage information")    
    protected boolean _help = false;
    
    public static void main(String[] argv) {
        CommandLine c = new CommandLine();
        c.start(new JCommander(c, argv));
    }
    
    public CommandLine() {}
    
    public void start(JCommander args) {
        this._optparse = args;
        
        if (this._help) {
            this._optparse.usage();
            System.exit(0);
        }
        
        this._validateArguments(); // Passing control to this.  Could exit out.
        
        if (this._filesExist(this._files)) {

        } else {
            this._exit("Can't read some (or all) of the files specified -- they might not exist");
        }
    }
    
    protected void _validateArguments() {
        if (this._files.size() == 0) {
            this._exit("No InstAL file(s) provided");
        }
    }

    protected boolean _filesExist(List<String> files) {
        Iterator<String> iter = files.iterator();
        while (iter.hasNext()) {
            String file = iter.next();
            File f = new File(file);
            
            if (!f.canRead()) {
                return false;
            }
        }
        
        return true;
    }
    
    protected void _exit(String message) {
        this._log(String.format("Error: %s", message), true);
        this._optparse.usage();
        System.exit(1);
    }
    
    protected void _log(String message, boolean force) {
        if (force || this._debug) {
            System.err.println(String.format("instal2asp: %s", message));
        }
    }
    
    protected void _log(String message) {
        this._log(message, false);
    }
}

