/**
 *
 * The MIT License
 *
 * Copyright 2006-2011 The Codehaus.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import java.io.*
import java.util.*


t = new IntegrationBase();

def daemonFolder = new File( basedir, "target/generated-resources/appassembler/jsw/daemon-1/")

//The bin folder where to find the generated scripts.
def fileBinFolder = new File( daemonFolder, "bin");

// Check the existence of the generated unix script
def unixScriptFile = new File( fileBinFolder, "daemon-1" );

t.checkExistenceAndContentOfAFile(unixScriptFile, [
    'APP_NAME="daemon-1"',
    'APP_LONG_NAME="Daemon Multiple Test Project"',
])

//conf folder.
def fileConfFolder = new File( daemonFolder, "conf");

// Check the existence of the generated wrapper.conf file.
def wrapperConfFile = new File( fileConfFolder, "wrapper.conf" );

t.checkExistenceAndContentOfAFile(wrapperConfFile, [
    'set.default.REPO_DIR=newLib',
    'wrapper.java.classpath.1=newLib/wrapper.jar',
    'wrapper.java.classpath.2=%REPO_DIR%/daemonMultipleTest-1.0-SNAPSHOT.jar',
    'wrapper.java.classpath.3=%REPO_DIR%/log4j-1.2.14.jar',
    'wrapper.java.library.path.1=newLib',
    'wrapper.java.additional.1=-Dtest=this',
    'wrapper.java.additional.2=-Dxyz=those',
    'wrapper.java.additional.3=-DTest',
    'wrapper.java.additional.4=-DXXX',

])

return true;
