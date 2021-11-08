package smith;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class Files{

	private Shell shell;
	
	public String open(Shell parent) {
  FileDialog fd = new FileDialog(parent, SWT.OPEN);
  fd.setText("Open");
  String selected = fd.open();
  return selected;
	}
}
