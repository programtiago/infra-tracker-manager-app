import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { DialogErrorData } from '../../../model/dialogErrorData';

@Component({
  selector: 'app-dialog-error',
  templateUrl: './dialog-error.component.html',
  styleUrl: './dialog-error.component.scss'
})
export class DialogErrorComponent {
  constructor(
    public dialogRef: MatDialogRef<DialogErrorComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogErrorData
  ) {}

  onClose(): void {
    this.dialogRef.close();
  }
}
