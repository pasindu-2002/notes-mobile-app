<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Note Application</title>
</head>
<body>
    <h1>Note Application</h1>

    <h2>Project Overview</h2>
    <p>
        The Note Application is a simple Android app designed for note-taking. Users can create, view, and delete notes.
        The app uses <code>SharedPreferences</code> for persistent storage, ensuring that notes are saved and available across sessions.
    </p>

    <h2>Features</h2>
    <ul>
        <li><strong>Add Notes:</strong> Create new notes with a title and content.</li>
        <li><strong>View Notes:</strong> Display a list of existing notes.</li>
        <li><strong>Delete Notes:</strong> Remove notes by long-pressing them and confirming deletion.</li>
        <li><strong>Persistent Storage:</strong> Notes are saved and loaded using <code>SharedPreferences</code>.</li>
    </ul>

    <h2>Installation Instructions</h2>
    <p>To set up the Note Application locally, follow these steps:</p>
    <ol>
        <li><strong>Clone the Repository:</strong>
            <pre><code>git clone https://github.com/yourusername/note-application.git</code></pre>
        </li>
        <li><strong>Open in Android Studio:</strong>
            <ul>
                <li>Launch Android Studio.</li>
                <li>Select <code>File</code> -> <code>Open</code>.</li>
                <li>Navigate to the cloned repository folder and open it.</li>
            </ul>
        </li>
        <li><strong>Sync Project with Gradle Files:</strong>
            <p>Android Studio should prompt you to sync. If not, go to <code>File</code> -> <code>Sync Project with Gradle Files</code>.</p>
        </li>
        <li><strong>Build and Run:</strong>
            <ul>
                <li>Connect an Android device or start an emulator.</li>
                <li>Click the <code>Run</code> button in Android Studio.</li>
            </ul>
        </li>
    </ol>

    <h2>Usage</h2>
    <ol>
        <li><strong>Add a Note:</strong>
            <ul>
                <li>Enter a title and content in the provided fields.</li>
                <li>Tap the save button to add the note.</li>
            </ul>
        </li>
        <li><strong>View Notes:</strong>
            <p>The list of notes will be displayed on the main screen.</p>
        </li>
        <li><strong>Delete a Note:</strong>
            <ul>
                <li>Long-press on a note to bring up the delete confirmation dialog.</li>
                <li>Confirm the deletion to remove the note.</li>
            </ul>
        </li>
    </ol>

    <h2>License</h2>
    <p>This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>

    <h2>Contributing</h2>
    <p>If you would like to contribute to this project, please fork the repository and submit a pull request. For significant changes, please open an issue first to discuss the change.</p>
</body>
</html>
