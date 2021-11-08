package smith;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class UIManager {

	protected Shell shell;
	private Text rootdir;
	private Text exedir;
	private Text text;
	private Text destdir;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void setup() {
		try {
			UIManager window = new UIManager();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("DePortablizer");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(shell, SWT.NONE);
		Button btnStart = new Button(composite, SWT.NONE);
		Label lblRoot = new Label(composite, SWT.NONE);
		rootdir = new Text(composite, SWT.BORDER);
		Button browseroot = new Button(composite, SWT.NONE);
		Label lblExe = new Label(composite, SWT.NONE);
		exedir = new Text(composite, SWT.BORDER);
		Button browseexe = new Button(composite, SWT.NONE);
		Button btnCreateStartMenuShortcut = new Button(composite, SWT.CHECK);
		Button btnCreateDesktopShortcut = new Button(composite, SWT.CHECK);
		Label lblName = new Label(composite, SWT.NONE);
		text = new Text(composite, SWT.BORDER);
		Label lblPath = new Label(composite, SWT.NONE);
		destdir = new Text(composite, SWT.BORDER);
		Button browsedest = new Button(composite, SWT.NONE);


		btnStart.setText("DePortablize");
		lblRoot.setText("Root");
		browseroot.setText("...");
		browseexe.setText("...");
		browsedest.setText("...");

		lblExe.setText("EXE");
		btnCreateDesktopShortcut.setText("Create desktop shortcut");
		btnCreateStartMenuShortcut.setText("Create Start menu shortcut");
		lblName.setText("Name");
		lblPath.setText("Path");
		destdir.setText("C:\\Program Files");

		btnStart.setBounds(10, 513, 762, 30);
		exedir.setBounds(10, 94, 280, 26);
		btnCreateDesktopShortcut.setBounds(378, 42, 186, 20);
		browseexe.setBounds(296, 90, 29, 30);
		lblExe.setBounds(10, 68, 70, 20);
		browseroot.setBounds(296, 34, 29, 30);
		rootdir.setBounds(10, 36, 280, 26);
		lblRoot.setBounds(10, 10, 70, 20);
		btnCreateStartMenuShortcut.setBounds(378, 68, 186, 20);
		lblName.setBounds(10, 126, 70, 20);
		text.setBounds(10, 152, 280, 26);
		lblPath.setBounds(10, 184, 70, 20);
		browsedest.setBounds(296, 208, 29, 30);
		destdir.setBounds(10, 210, 280, 26);
		
		
		
		btnCreateStartMenuShortcut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		
		browsedest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Files q = new Files(shell, 0, "Select EXE");
				destdir.setText(q.open());
			}
		});
		
		browseroot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Files q = new Files(shell, 0, "Select EXE");
				rootdir.setText(q.open());
			}
		});
		
		browseexe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Files q = new Files();
				String txt = q.open(shell);
				if (txt != null) {
				exedir.setText(txt);
				}
			}
		});

		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DePortablizer.StartInstall(lblName.getText(), exedir.getText(), rootdir.getText(), false, btnCreateStartMenuShortcut.getSelection(), btnCreateDesktopShortcut.getSelection(), destdir.getText());
			}
		});
	}
}
