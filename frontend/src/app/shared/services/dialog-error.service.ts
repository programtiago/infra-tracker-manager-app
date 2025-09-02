import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogErrorComponent } from '../components/dialog-error/dialog-error.component';
import { DialogErrorData } from '../../model/dialogErrorData';

@Injectable({
  providedIn: 'root'
})
export class DialogErrorService {

  constructor(private dialog: MatDialog) {}

  openErrorDialog(message: string, title: string, details?: string): void {
    this.dialog.open<DialogErrorComponent, DialogErrorData>(DialogErrorComponent, {
      width: '420px',
      data: { title, message, details }
    });
  }
}
