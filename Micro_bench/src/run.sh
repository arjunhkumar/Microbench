#-----Modify the path to java_home below.
benchmark=$1
_java_="/home/arjun/Working_Directory/Softwares/Utilities/openj9-valuetypes/jdk/bin/java"

run_bench() {
    benchmark=$1
    logfile="${benchmark}_prim.log"
    if [ -f "$logfile" ]; then
        rm $logfile
    fi

    for i in 1 2 3 4 5
    do
        echo "--------------------------------------------------------------" | tee -a $logfile
        echo "Iteration $i" | tee -a $logfile
        sudo perf stat -e cache-misses $_java_ -XX:ValueTypeFlatteningThreshold=99999 TestSuite $1 "true" 2>&1 | tee -a $logfile
        echo "--------------------------------------------------------------" | tee -a $logfile
    done

    logfile="${benchmark}_nonprim.log"
    if [ -f "$logfile" ]; then
        rm $logfile
    fi
    for i in 1 2 3 4 5
    do
        echo "--------------------------------------------------------------" | tee -a $logfile
        echo "Iteration $i" | tee -a $logfile
        sudo perf stat -e cache-misses $_java_ TestSuite $1 "false" 2>&1 | tee -a $logfile
        echo "--------------------------------------------------------------" | tee -a $logfile
    done
}

run_bench $benchmark
