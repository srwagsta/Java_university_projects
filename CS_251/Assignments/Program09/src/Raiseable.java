/**
 * Interface to help better implement a program that holds
 * the salaries of employees within a small business
 * @author Stephen_Wagstaff
 */
interface Raiseable
{
    /**
    * Creates a new (empty) file that can later be used to
    * add entries of the above format
    */
    void create(String fileName);

    /**
     * Formats and displays the
     * contents of the specified file to the screen
     */
    void display(String fileName);

    /**
     * Creates a new file that is a copy of the given
     * input file - with the new entry added such that
     * the new file is sorted by the entries’ ids Return true
     * if no match was found and the entry was added;
     * false if a duplicate id
     * @param inFileName
     * @param outFileName
     * @param id
     * @param salary
     * @param yearsOfService
     * @return THe boolean result of adding the salary
     */
    boolean addTo(String inFileName, String outFileName,
                  int id, double salary, int yearsOfService);

    /**
     *  Creates a new file that is a copy of the given
     *  input file - with the specified entry removed
     *  Returns true if a matching entry was found / removed;
     *  false if no such entry exists
     * @param inFileName
     * @param outFileName
     * @param id
     * @param salary
     * @param yearsOfService
     * @return Returns the result of the remove opperation
     */
    boolean removeFrom(String inFileName, String outFileName,
                       int id, double salary, int yearsOfService);

    /**
     *  Creates a new file that is a copy of the given
     *  input file - where all entries whose years of
     *  service are greater than or equal to yearsOfService
     *  have had their salaries increased by salaryIncPercent
     *  Return the number of entries that the raise was applied to
     * @param inFileName
     * @param outFileName
     * @param yearsOfService
     * @param salaryIncPercent
     * @return The number of entries that raise was applied to
     */
    int raise(String inFileName, String outFileName, int yearsOfService,
              double salaryIncPercent);

    /**
     * Creates a new file that is a sorted merge of the
     * two given (sorted) input files In case of
     * duplicate entries, only the one with the highest
     * salary is kept in outFileName
     * @param inFileName1
     * @param inFileName2
     * @param outFileName
     */
    void mergeFiles(String inFileName1, String inFileName2, String outFileName);
}