#!/bin/bash
#-----Modify the path to java_home below.
benchmark=$1
_java_="/home/arjun/Working_Directory/Softwares/Utilities/openj9-valuetypes/jdk/bin/java"

run_bench() {
    benchmark=$1
    logfile="${benchmark}_prim.log"
    if [ -f "$logfile" ]; then
        rm $logfile
    fi
    #-----Run the benchmark with primitive value type objects.
    echo "--------------------------------------------------------------" | tee -a $logfile
    #$_java_ -XX:ValueTypeFlatteningThreshold=99999 '-Xjit:verbose,log=prim.log' TestSuite $1 "true" 2>&1 | tee -a $logfile
    $_java_ -XX:ValueTypeFlatteningThreshold=99999 '-Xjit:{in/ac/iitmandi/compl/benchmarks/SingleObjectLoopTest.executeTest(Z)V}(traceFull,log=primcase.log)' TestSuite $1 "true" 2>&1 | tee -a $logfile
    echo "--------------------------------------------------------------" | tee -a $logfile
    logfile="${benchmark}_nonprim.log"
    if [ -f "$logfile" ]; then
        rm $logfile
    fi
    
    #-----Run the benchmark with conventional java objects.
    echo "--------------------------------------------------------------" | tee -a $logfile
    #$_java_ '-Xjit:verbose,log=nonprim.log' TestSuite $1 "false" 2>&1 | tee -a $logfile
    $_java_ '-Xjit:{in/ac/iitmandi/compl/benchmarks/SingleObjectLoopTest.executeTest(Z)V}(traceFull,log=nonprimcase.log)' TestSuite $1 "false" 2>&1 | tee -a $logfile
    echo "--------------------------------------------------------------" | tee -a $logfile
}

run_bench $benchmark