package uk.ac.bath.cs.agents.instal.instal2asp;

import java.io.*;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import org.antlr.runtime.*;

import uk.ac.bath.cs.agents.instal.parser.*;

public class CommandLine {
    
    protected JCommander _optparse;
    
    @Parameter(description = "<InstAL specification>+")
    protected List<String> _files = new ArrayList<String>();
    
    @Parameter(names = "--debug", description = "Debug mode")
    protected boolean _debug = false;

    @Parameter(names = {"--help", "-h", "-?"}, description = "Show usage information")    
    protected boolean _help = false;

    @Parameter(names = {"-d", "--domain-file"}, description = "Domain file", required = true)
    protected String _domainFilePath;
    
    public static void main(String[] argv) {
        CommandLine c = new CommandLine(argv);
        c.start();
    }
    
    public CommandLine(String[] argv) {
        this._parseArguments(argv);
    }
    
    public void start() {
        if (this._help) {
            this._optparse.usage();
            System.exit(0);
        }
        
        this._validateArguments(); // Passing control to this.  Could exit out.
        
        if (this._filesExist(this._files)) {
            Iterator<String> iter = this._files.iterator();
            while (iter.hasNext()) {
                String file = iter.next();
                this._parseFile(file);
            }
        } else {
            this._exit("Can't read some (or all) of the files specified -- they might not exist");
        }
    }

    protected void _parseArguments(String[] argv) {
        try {
            this._optparse = new JCommander(this, argv);
        } catch (ParameterException e) {
            this._exit(e.getMessage());
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
    
    protected void _parseFile(String file) {
        try {
            
            this._log("Parsing file: " + file);
            
            CharStream cs = new ANTLRFileStream(file, "UTF8");
            InstALLexer lex = new InstALLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lex);
            InstALParser g = new InstALParser(tokens, null);
            
            g.instal_specification();
        } catch (RecognitionException e_r) {
            this._exception("RecognitionException: " + e_r.getMessage());
        } catch (IllegalArgumentException e_i) {
            this._exception("NickException: " + e_i.getMessage());
        } catch (Exception e) {
            this._exception("GeneralException: " + e.getMessage());
        }
    }
    
    protected void _exception(String message) {
        this._log(String.format("An exception occurred: %s", message), true);
        System.exit(2);
    }
    
    protected void _exit(String message) {
        this._log(String.format("Error: %s", message), true);
        if (this._optparse != null) {
            this._optparse.usage();
        }
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

