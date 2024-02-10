import {Component} from '@angular/core';
import {ModelService} from "../../service/model.service";
import {Models} from "../../model/models";
import {ActivatedRoute, Router} from "@angular/router";
import {AppComponent} from "../../../app.component";
import {Brand} from "../../../brand/model/brand";
import {Model} from "../../model/model";

@Component({
  selector: 'app-model-list',
  templateUrl: './model-list.component.html',
  styleUrls: ['./model-list.component.css', '../../../tables.css']
})
export class ModelListComponent {

  constructor(private service: ModelService,
              private route: ActivatedRoute,
              private router: Router) {

  }

  models: Models | undefined;

  brandsUuid: string | undefined;
  ngOnInit(): void {
    this.route.params.subscribe(params => {
        this.service.getBrandsModels(params['uuid'])
            .subscribe(models => this.models = models);
        this.brandsUuid = params['uuid'];
    })
    }

  onDelete(model: Model): void {
    this.service.deleteModel(model.id).subscribe(() => this.ngOnInit());
  }


}
